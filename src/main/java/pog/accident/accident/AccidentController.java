package pog.accident.accident;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

    private AccidentService accidentService;
    @GetMapping("/{accidentId}")
    public AccidentDTO getAccident(@PathVariable Long accidentId) throws Exception {
        return accidentService.getAccident(accidentId);
    }


    // TODO 저장하고 사고id랑 분류 반환해야함
    @PostMapping
    public Map<String, String> saveAccident(AccidentDTO accidentDTO) {
        // accidentService.saveAccident(accidentDTO);
        Map<String, String> result = new HashMap<>();

        return result;
    }
}
