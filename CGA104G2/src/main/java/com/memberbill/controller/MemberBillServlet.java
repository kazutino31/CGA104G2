package com.memberbill.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.card.model.CardVO;
import com.memberbill.model.MemberBillService;
import com.memberbill.model.MemberBillVO;
import com.transfer.model.TransferService;
import com.transfer.model.TransferVO;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

//http://localhost:8081/xxx/
@WebServlet("/member/bill.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class MemberBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberBillService memSvc = new MemberBillService();
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		Integer userId = 0;
		

		if ("getAll".equals(action)) {
			List<MemberBillVO> list = memSvc.getAll();
			req.setAttribute("list", list);
			req.getRequestDispatcher("/back-end/memberbill/getAll.jsp").forward(req, res);

			// 取得下拉選單日期
			TransferService transferService2 = new TransferService();
			List<String> vo2 = transferService2.getOneBillDate();// 查詢繳費 年/月
			// 放入session給前端用
			session.setAttribute("vo2", vo2);// set保存

		} else if ("memberphoto".equals(action)) {

			Integer MemberBillID = Integer.valueOf(req.getParameter("memberBillId"));
			byte[] memberPhoto = memSvc.getOnePhoto(MemberBillID);
			if (memberPhoto != null) {
				res.getOutputStream().write(memberPhoto);
			} else {
				System.out.println("照片");

			}
		}
		if ("getOne_For_Update".equals(action)) { // 抓近來都是String
			Integer memberBillId = Integer.parseInt(req.getParameter("memberBillId")); // 將取過來的String轉Integer(後端設定的數字才能判斷)
			String memberPay = req.getParameter("memberPay"); // getParameter從jsp取參數的方法// 將取過來的String轉Integer
			memSvc.update(memberBillId, memberPay);
			// forward to addMember.jsp//修改的內容在同個頁面顯示
			res.sendRedirect("bill.do?action=getAll"); // 除了forward另一種跳轉的方式sendRedirect
		}
		if ("insert".equals(action)) {//新增照片進資料庫
			// 以下為接收請求參數(Request Parameter)//把請求的參數取進來
			List<MemberBillVO> list = memSvc.getUnpaid(userId);
			Part file = req.getPart("file"); // 檔案用part裝
			byte[] memberPhoto = file.getInputStream().readAllBytes(); // 把所有轉byte[]的檔案讀進來(取到)
			MemberBillVO vo = new MemberBillVO(); // 從VO取
			vo.setMemberPhoto(memberPhoto);
			memSvc.uploadPhoto(vo); // service也要
			req.getRequestDispatcher("/front-end/memberbill/transfer_2.jsp").forward(req, res);
		}

		if ("ID".equals(action)) { // 登入
			userId = Integer.valueOf(req.getParameter("ID"));
			session.setAttribute("memberId", userId);
			String url = req.getContextPath() + "/front-end/memberbill/pay.jsp";
			res.sendRedirect(url);

		}

		if ("memberphoto".equals(action)) {
			Integer memberBillID = Integer.valueOf(req.getParameter("memberBillId"));
			byte[] memberPhoto = memSvc.getOnePhoto(memberBillID);
			res.getOutputStream().write(memberPhoto);
		}

		if ("select_Transfer".equals(action)) {// 後台上方的查詢列(匯款及刷卡)

			/*************************** 1接收請求參數 **********************/

			String billDate = req.getParameter("billDate2");// 下拉選單的月份選擇
			/*************************** 2開始查詢資料 *****************************************/
			String memberPayMethod = req.getParameter("memberPayMethod");

			if (memberPayMethod.equals("0")) {// 匯款頁面

				TransferService transferService = new TransferService();
				List<TransferVO> list = transferService.getAll(billDate);
				req.setAttribute("list", list);
				String url = "/back-end/memberbill/getTransfer.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} else {// 刷卡頁面
				String url = "/back-end/memberbill/getCard.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);
			}
		}
		//匯款按鈕至匯款頁面
		if ("transfer".equals(action)) {
			String billGroup="9";
			MemberBillService memberBillService = new MemberBillService();
			MemberBillVO memberBillVO=memberBillService.getBillDate(billGroup);
			req.setAttribute("memberBillVO", memberBillVO);
			String url = "/front-end/memberbill/transfer.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
			System.out.print("innn");
			
			
		}

		//刷卡按鈕
		if ("pay".equals(action)) {
			List<MemberBillVO> listBillVos = memSvc.getAllCost("9");
			Integer billAmount = listBillVos.stream().mapToInt(e -> Integer.valueOf(e.getBillAmount())).sum();
//			System.out.print(billAmount);//測試
			req.setAttribute("listBillVos", listBillVos);
			req.getRequestDispatcher("/front-end/memberbill/pay.jsp").forward(req, res);
			System.out.print("yyyy");
		}
		 if ("pay".equals(action)) {
		    	MemberBillService memSvc = new MemberBillService();
		    	List<MemberBillVO> memberBillVO=memSvc.getAll();
		    	List<String> getAll=new ArrayList<String>();
		    	List<MemberBillVO> getAllCost = memberBillVO
		    			.stream()
		    			.map(MemberBillVO :: getCostName)
		    			.toList();
		    	List<MemberBillVO> getAllCost1 = memberBillVO
		    			.stream()
		    			.map(MemberBillVO :: getBillAmount)
		    			.toList();
		    	for(int i=0;i<getAllCost.size;i++) {
		    		
		    		getAll.add(getAllCost.get(i)+"#"+getAllCost1.get(i));
		    	};
		    	String itemName = String.ValurOf(getAllCost.get());
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		        String payDate = sdf.format(new Date(System.currentTimeMillis()));
		        AllInOne allInOne = new AllInOne("");
		        AioCheckOutALL aioCheckOutALL = new AioCheckOutALL();
		        
		        int billGroup = (int) (Math.random() * 2999+ 1000);
		        String merchantTradeNo=String.valueOf(billGroup);
		        
		        aioCheckOutALL.setMerchantTradeNo(merchantTradeNo);
		        aioCheckOutALL.setMerchantTradeDate(payDate);
		        aioCheckOutALL.setTotalAmount(String.valueOf(memberBillVO.getBillAmount()));
		        aioCheckOutALL.setTradeDesc("付款測試");
		        aioCheckOutALL.setReturnURL(req.getRequestURL()+"/front-end/memberbill/card.jsp");
		        aioCheckOutALL.setClientBackURL(req.getRequestURL()+"/front-end/memberbill/card.jsp");
		        aioCheckOutALL.setNeedExtraPaidInfo("N");
		        aioCheckOutALL.setItemName(itemName);
		        aioCheckOutALL.CustomField1();
		        
		        allInOne.aioCheckOut(aioCheckOutALL,null);
		        req.setAttribute("checkoutPage",getAllCost);
		        RequestDispatcher goCheckout = req.getRequestDispatcher(req.getRequestURL()+"/front-end/memberbill/card.jsp");
		        goCheckout.forward(req, res);
		    }

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}