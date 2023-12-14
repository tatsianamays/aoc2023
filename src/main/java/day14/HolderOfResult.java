package day14;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HolderOfResult {
    char[][] input;
    boolean hadMoves;
}
