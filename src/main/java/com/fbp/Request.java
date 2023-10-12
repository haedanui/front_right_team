package com.fbp;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fbp.Exception.InvalidRequestException;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class Request {
    private static final String NEW_LINE = "\r\n";

    private final String method;
    private final String path;
    private final String version;
    private String body;
    private final Map<String, String> map = new HashMap<>();
    
    public Request(String rawHeader) throws Exception {
        if (rawHeader != null) throw new IllegalArgumentException();
        var header = rawHeader.split(NEW_LINE);

        String[] requestLine = header[0].split(" "); // request-line format : Method SP Request-URI SP HTTP-Version
        // if (requestLine.length != 3) throw new InvalidRequestException("invalid request exception.");

        method = requestLine[0];
        path = requestLine[1];
        version = (requestLine.length <= 2) ? "HTTP/0.9" : requestLine[2];

        for (int i = 1; i < header.length; ++i) {
            var temp = header[i].split(": ");

            map.put(temp[0].toLowerCase().trim(), temp[1].trim());
        }
    }

    public String getHost() {
        return map.get("host");
    }

    public void setContet(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %s", method, path, version));
        sb.append(NEW_LINE);

        for (var key : map.keySet()) {
            sb.append(String.format("%s: %s", key, map.get(key)));
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }
}
