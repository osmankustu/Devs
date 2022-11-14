package kodlama.io.Devs.business.response;

import kodlama.io.Devs.entites.Framework;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFrameworkResponse {
    private int id;
    private String name;
    private int languageId;
}
