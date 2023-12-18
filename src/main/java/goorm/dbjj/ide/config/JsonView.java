package goorm.dbjj.ide.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import goorm.dbjj.ide.model.IdeResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

public class JsonView extends MappingJackson2JsonView {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (JsonGenerator generator = this.objectMapper.getFactory().createGenerator(response.getOutputStream(), this.getEncoding())){
            generator.setPrettyPrinter(new DefaultPrettyPrinter());
            this.objectMapper.writeValue(generator, toIdeResponse(model));
        }
    }

    private IdeResponse toIdeResponse(Map<String, Object> model) {
        return IdeResponse.ok(model);
    }
}
