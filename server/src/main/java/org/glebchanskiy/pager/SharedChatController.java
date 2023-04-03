package org.glebchanskiy.pager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/shared")
public class SharedChatController {
    @GetMapping()
    public Map<String, String> getAllMessages() {
        Map<String, String> map = new HashMap<>();
        map.put(
                "Hello", "Gleb"
        );
        return map;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addMessage(@RequestBody Map<String, String> message) {
        System.out.println(message);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
