package guard.passer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Stdin {
    String userId;
    String clorderId;
    Character action;
    Integer instrumentId;
    Character side;
    Long price;
    Integer amount;
    Integer amountRest;
}