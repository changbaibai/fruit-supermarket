package com.edu.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.edu.dao.AdminGoodsDao;
import com.edu.service.AdminGoodsService;
import com.edu.po.Goods;
import com.util.MyUtil;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private AdminGoodsDao adminGoodsDao;
	/**
	 * ��ӻ����
	 */
	@Override
	public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct) {
		/*�ϴ��ļ��ı���λ��"/logos"����λ����ָ
		workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps��
		������ʹ��*/
		//��ֹ�ļ�������
		String newFileName = "";
		String fileName = goods.getLogoImage().getOriginalFilename(); 
		//ѡ�����ļ�
		if(fileName.length() > 0){
			String realpath = request.getServletContext().getRealPath("logos");
			//ʵ���ļ��ϴ�
			String fileType = fileName.substring(fileName.lastIndexOf('.'));
			//��ֹ�ļ�������
			newFileName = MyUtil.getStringID() + fileType;
			goods.setGpicture(newFileName);
			File targetFile = new File(realpath, newFileName); 
			if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        } 
			//�ϴ� 
	        try {   
	        	goods.getLogoImage().transferTo(targetFile);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		}
		//�޸�
		if("update".equals(updateAct)){//updateAct������act��������Ϊʹ����ת��
			//�޸ĵ����ݿ�
	       if(adminGoodsDao.updateGoodsById(goods) > 0){
	        	return "forward:/adminGoods/selectGoods?act=updateSelect";
	        }else{
	        	return "/adminGoods/updateAgoods";
	       }
		}else{//��
			//���浽���ݿ�
			if(adminGoodsDao.addGoods(goods) > 0){
				//ת������ѯ��controller
				return "forward:/adminGoods/selectGoods";
			}else{
				return "card/addCard";
			}
		}
	}
	/**
	 * ��ѯ��Ʒ
	 */
	@Override
	public String selectGoods(Model model, Integer pageCur, String act) {
		List<Goods> allGoods = adminGoodsDao.selectGoods();
		int temp = allGoods.size();
		model.addAttribute("totalCount", temp);
		int totalPage = 0;
		if (temp == 0) {
			totalPage = 0;//��ҳ��
		} else {
			//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage = (int) Math.ceil((Integer) temp / 10);
		}
		if (pageCur == null) {
			pageCur = 1;
		}
		if ((pageCur - 1) * 10 > temp) {
			pageCur = pageCur - 1;
		}
		//��ҳ��ѯ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startIndex", (pageCur - 1) * 10);//��ʼλ��
		map.put("perPageSize", 10);//ÿҳ10��
		allGoods = adminGoodsDao.selectAllGoodsByPage(map);
		model.addAttribute("allGoods", allGoods);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		//ɾ����ѯ
		if("deleteSelect".equals(act)){
			return "admin/deleteSelectGoods";
		}
		//�޸Ĳ�ѯ
		else if("updateSelect".equals(act)){
			return "admin/updateSelectGoods";
		}else{
			return "admin/selectGoods";
		}
	}
	/**
	 * ��ѯһ����Ʒ
	 */
	@Override
	public String selectAGoods(Model model, Integer id, String act) {
		Goods agoods = adminGoodsDao.selectGoodsById(id);
		model.addAttribute("goods", agoods);
		//�޸�ҳ��
		if("updateAgoods".equals(act)){
			return "admin/updateAgoods";
		}
		//����ҳ��
		return "admin/goodsDetail";
	}
	/**
	 * ɾ�������Ʒ
	 */
	@Override
	public String deleteGoods(Integer[] ids, Model model) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ids.length; i++) {
			//��Ʒ�й���
			if(adminGoodsDao.selectCartGoods(ids[i]).size() > 0 ||
					adminGoodsDao.selectFocusGoods(ids[i]).size() > 0 || 
					adminGoodsDao.selectOrderdetailGoods(ids[i]).size() > 0) {
				model.addAttribute("msg", "删除成功");
				return "forward:/adminGoods/selectGoods?act=deleteSelect";
			}
			list.add(ids[i]);
		}
		adminGoodsDao.deleteGoods(list);
		model.addAttribute("msg", "删除失败");
		return "forward:/adminGoods/selectGoods?act=deleteSelect";
	}
	/**
	 * ɾ��һ����Ʒ
	 */
	@Override
	public String deleteAGoods(Integer id, Model model) {
		//��Ʒ�й���
		if(adminGoodsDao.selectCartGoods(id).size() > 0 ||
				adminGoodsDao.selectFocusGoods(id).size() > 0 || 
				adminGoodsDao.selectOrderdetailGoods(id).size() > 0) {
			model.addAttribute("msg", "删除失败");
			return "forward:/adminGoods/selectGoods?act=deleteSelect";
		}
		adminGoodsDao.deleteAGoods(id);
		model.addAttribute("msg", "删除成功");
		return "forward:/adminGoods/selectGoods?act=deleteSelect";
	}
}
