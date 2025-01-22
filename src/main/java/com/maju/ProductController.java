package com.maju;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.majustory.product.ProductService;
import com.majustory.product.ProductVO;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@Autowired
	private  ProductService  service; 
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	String pathTest ="";
		
	ProductController(){
	  System.out.println("==> ProductController ");	
	}
	
    @PostConstruct 
	public void init() {
		System.out.println("===> initialize() 메소드 실행 "); 
		pathTest = servletContext.getRealPath("/product/files/");
	}
    
	
	@GetMapping("/productForm")
	void productForm(Model  model){
		   System.out.println("==> productForm ");	
	   model.addAttribute("pid", service.pid())	 ;
	}
	
	
	@PostMapping("/productFormOK")
	public String productFormOK( ProductVO vo , HttpServletRequest  request) 
		     throws Exception, IOException {			

		
			
		  Random rnd = new Random();
		  String RName = (rnd.nextInt(999999)+100001)+"";
		  
		    MultipartFile file = vo.getPimg();
		    String fileName = file.getOriginalFilename();
		    File F = new File(pathTest+fileName);
		    if (!file.isEmpty()) {
			    if (F.exists()) {
			     String	Fname = fileName.substring(0, fileName.lastIndexOf("."));
			     String Lname = fileName.substring(fileName.lastIndexOf("."));
			     fileName = Fname + "_" + RName + Lname;
			    }
		    } else {
		    	fileName ="space.png";
		    }
		    vo.setPimgStr(fileName);	    
		    file.transferTo(new File(pathTest+fileName));
		    		  
			service.insert(vo);			
			
		   return "redirect:/product/productList";		
		}		
	
	
	@RequestMapping("/productList")
	void productListL( Model  model, ProductVO vo ){	
		 System.out.println("==> productListG ");	
		 
		    int start = 0;
			int pageSize = 12;
			int pageListSize = 5;
			
			int totalCount = service.totalcount(vo);
			
			if (vo.getStart() ==0) {
				start = 1 ;
			}else {
				start = vo.getStart();
			}
			
			int  end = start + pageSize - 1 ;
			int  totalPage =(int) (Math.ceil((double) totalCount / pageSize));  // 전체페이지 수 
			int  currentPage = (start / pageSize) + 1;  // 현재페이지 
			
			int  lastPage = (totalPage - 1) * pageSize + 1;  // 마지막 페이지
			
		    int  listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;   // 하단 번호 시작
		    int  listEndPage = listStartPage + pageListSize - 1;   // 하단 번호 끝
			
		    // 1. 페이지 사이즈
		    model.addAttribute("pageSize", pageSize);
		    
		    // 2. 페이지 list 사이즈
		    model.addAttribute("pageListSize", pageListSize);
		    
		    // 3. 전체레코드 수
		    model.addAttribute("totalCount", totalCount);
		    
		    // 4. 총페이지 수
		    model.addAttribute("totalPage", totalPage);
		    
		    // 5. 현재레코드 
		    model.addAttribute("start", start);
		    
		    // 6. 현재 페이지:
		    model.addAttribute("currentPage", currentPage);
		    
		    // 7. 하단 가로 시작:
		    model.addAttribute("listStartPage", listStartPage);
		    
		    // 8. 하단 가로 끝 :
		    model.addAttribute("listEndPage", listEndPage);
		    
		    // 9. 마지막페이지 :
		    model.addAttribute("lastPage", lastPage);
		    
		    vo.setStart(start);
		    vo.setEnd(end);
		    vo.setPageSize(pageSize);
		    
		    model.addAttribute("ch1",vo.getCh1());
		    model.addAttribute("ch2",vo.getCh2());
		    model.addAttribute("li", service.list(vo));
	}
	
	@GetMapping("/productEdit")
	void productEdit( Model  model , ProductVO vo  ){
		 System.out.println("==> productEdit ");
		 model.addAttribute("m", service.edit(vo));
		 
	}
	
	@PostMapping("/cartInsert")
	String cartInsert( ProductVO vo  ){
		 System.out.println("==> cartInsert ");
		 service.cartInsert(vo);
		return "redirect:/product/productList";
		 
	}
	
	@GetMapping("/cartList")
	void cartList( Model  model,  ProductVO vo){
		 System.out.println("==> productList " );	
		 List<ProductVO>  li = service.cartList(null);
		 
		 if(li.size() >0) {
			 ProductVO  mm = li.get(0);		
			 model.addAttribute("mm", mm.getCid());
		 }
		 int total = 0;
		 for(ProductVO m : li) {
			 total = total + m.getPprice()*Integer.parseInt(m.getAmount());
		 }
		 model.addAttribute("li", service.cartList(null));
		 model.addAttribute("total", total);
	    
	}
	
	@GetMapping("/cartDel")
	String cartDel( ProductVO vo , Model  model ){
		 System.out.println("==> cartDel ");
		 service.cartDel(vo);
		 model.addAttribute("li", service.cartList(null));
		return "/product/cartList";
		 
	}
	
	@GetMapping("/cartDel2")
	String cartDel2( String [] cid , Model  model , ProductVO vo ){
		 System.out.println("==> cartDel " + cid.length);
		 for (int i=0 ; i < cid.length ; i++) {
			 vo.setCid(cid[i]);
			 System.out.println("==> cartDel(삭제) : " + cid[i]);
			 service.cartDel(vo);
			 
		 }

		model.addAttribute("li", service.cartList(null));
		return "/product/cartList";
		 
	}
	
}
