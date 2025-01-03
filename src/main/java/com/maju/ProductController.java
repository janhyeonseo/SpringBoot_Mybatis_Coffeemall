package com.maju;

import java.io.File;
import java.io.IOException;
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
	public String productFormOK(Model  model, ProductVO vo , HttpServletRequest  request) 
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
	
	@GetMapping("/productList")
	void productListL( Model  model ){		
		 model.addAttribute("li", service.list(null));
		 System.out.println("==> productList ");		 
	}
	
	@PostMapping("/productList")
	void productListF( Model  model ){		
		 model.addAttribute("li", service.list(null));
		 System.out.println("==> productList ");		 
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
	void cartList( Model  model ){
		 System.out.println("==> productList ");	
		 List<ProductVO>  li = service.cartList(null);
		 
		 int totalPay = 0 ;
		 if ( li.size() > 0 ) {
			 
			 for(int i = 0 ; i <li.size()  ; i++) {
				 totalPay = totalPay + li.get(i).getPprice() * li.get(i).getAmount();
		}	 
			 
			 ProductVO  mm = li.get(0);		
			 model.addAttribute("totalPay", totalPay);
			 model.addAttribute("mm", mm.getCid());
			 model.addAttribute("li", service.cartList(null));
		 } else {
			 model.addAttribute("li", service.cartList(null));
		 }
	
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
