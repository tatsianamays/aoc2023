package day4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineStats {

    int gameNumber;
    String line;
    int sum;
}
