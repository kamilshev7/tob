package guard.passer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Stdout {
    Integer instrumentId;
    Character side;
    Long price;
    Integer amount;
}