import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/rest")
public class ublicationController {
    @Autowired
    private TypeServive typeService;

    @GetMapping("/publication")
    public TypeService getType(){
        return typeService.get();
    }

}