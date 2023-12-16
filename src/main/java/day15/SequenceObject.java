package day15;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SequenceObject {
    String chars;
    int focalLength;

    public String toString() {
        return chars + " " + focalLength;
    }
}
