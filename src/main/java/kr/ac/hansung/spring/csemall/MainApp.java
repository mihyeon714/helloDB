package kr.ac.hansung.spring.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//스프링 컨테이너 만들기
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("kr/ac/hansung/spring/csemall/beans/beans.xml");

		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");//bean객체 가져오기
		System.out.println("The record count is " + offerDAO.getRowCount()); //레코드 수가 출력될것
		
		
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer: offerList){
			System.out.println(offer);
		}
		context.close();
	}

}
