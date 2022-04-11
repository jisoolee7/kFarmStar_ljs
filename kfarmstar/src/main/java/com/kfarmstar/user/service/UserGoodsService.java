package com.kfarmstar.user.service;

import java.text.NumberFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.dto.Goods;
import com.kfarmstar.user.mapper.UserGoodsMapper;

@Service
@Transactional
public class UserGoodsService {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserGoodsService.class);


	//DI 의존성 주입 생성자 메서드 주입 방식
	private UserGoodsMapper userGoodsMapper;
	
	public UserGoodsService(UserGoodsMapper userGoodsMapper) {
		this.userGoodsMapper = userGoodsMapper;
	}
	
	// 사용자 화면 - 상품 전체 목록 조회
	public List<Goods> getUserGoodsList() {
		List<Goods> userGoodsList = userGoodsMapper.getUserGoodsList();
		// 금액 표시 : 세자리 마다 쉼표 찍어주고 + '원'
		NumberFormat numberFormat = NumberFormat.getInstance();
		for(int i=0; i<userGoodsList.size(); i++) {
			int refurbPrice = Integer.parseInt(userGoodsList.get(i).getGoodsRefurbPrice());
			int normalPrice = Integer.parseInt(userGoodsList.get(i).getGoodsNormalPrice());

			String refurbResult = numberFormat.format(refurbPrice);
			String nomalResult = numberFormat.format(normalPrice);
            
			userGoodsList.get(i).setGoodsRefurbPrice(refurbResult);
			userGoodsList.get(i).setGoodsNormalPrice(nomalResult);
		}
		
		return userGoodsList;
	}
	
	
	// 사용자 화면 - 상품 코드별 상세 정보 조회
	public Goods getUserGoodsByCode(String goodsRefurbCode) {
		Goods goods = userGoodsMapper.getUserGoodsByCode(goodsRefurbCode);
		// 금액 표시 : 세자리 마다 쉼표 찍어주고 + '원'
		NumberFormat numberFormat = NumberFormat.getInstance();
		int refurbPrice = Integer.parseInt(goods.getGoodsRefurbPrice());
        int normalPrice = Integer.parseInt(goods.getGoodsNormalPrice());
        	
        String refurbResult = numberFormat.format(refurbPrice);
        String nomalResult = numberFormat.format(normalPrice);
        
        goods.setGoodsRefurbPrice(refurbResult + " 원");
        goods.setGoodsNormalPrice(nomalResult + " 원");
		
        //배송비 표시 : 세자리 마다 쉼표 찍어주고 + '원'+ 0원이면 무료배송
        String goodsDeliveryCharge = goods.getGoodsDeliveryCharge();
        if (goodsDeliveryCharge.equals("0")) {
        	goodsDeliveryCharge = "무료배송";
        	goods.setGoodsDeliveryCharge(goodsDeliveryCharge);
		}else {
			int goodsDeliveryFee = Integer.parseInt(goodsDeliveryCharge);
			String deliveryChargeResult = numberFormat.format(goodsDeliveryFee);
			deliveryChargeResult = deliveryChargeResult + " 원";
			goods.setGoodsDeliveryCharge(deliveryChargeResult);
		}
        
        log.info("goods {}", goods);
		return goods;
	}
	
	// 사용자 화면 - 특정 상품을 제외하고  네 가지 상품 랜덤 조회
		public List<Goods> getRandomGoods(String goodsRefurbCode) {
			List<Goods> randomGoods = userGoodsMapper.getRandomGoods(goodsRefurbCode);
			// 금액 표시 : 세자리 마다 쉼표 찍어주고 + '원'
			NumberFormat numberFormat = NumberFormat.getInstance();
			for(int i=0; i<randomGoods.size(); i++) {
				int refurbPrice = Integer.parseInt(randomGoods.get(i).getGoodsRefurbPrice());

				String refurbResult = numberFormat.format(refurbPrice);
	            
				randomGoods.get(i).setGoodsRefurbPrice(refurbResult + "원");
			}
			
			return randomGoods;
		}
	
}
