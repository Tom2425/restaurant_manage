package logic;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api")
public class logic {
	 @GetMapping("/data")
	    public String getData() {
	        return "Hello from backend!";
	    }

	    @PostMapping("/update")
	    public String updateData(@RequestBody String newData) {
	        // Xử lý dữ liệu từ phía frontend
	        return "Data updated successfully!";
	    }
}
