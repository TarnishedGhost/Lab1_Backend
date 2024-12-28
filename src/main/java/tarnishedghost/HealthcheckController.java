package tarnishedghost;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthcheckController {

    @GetMapping("/healthcheck")
    public ResponseEntity<Map<String, Object>> healthcheck() {
        Map<String, Object> response = new HashMap<>();
        ZoneId kyivZone = ZoneId.of("Europe/Kiev");
        ZonedDateTime now = ZonedDateTime.now(kyivZone);

        String formattedDate = now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        response.put("Status", "Service is working as intended.");
        response.put("Data", formattedDate);
        return ResponseEntity.ok(response);
    }
}
