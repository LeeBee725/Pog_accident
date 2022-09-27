package pog.accident.accident;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccidentDTO {


    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
