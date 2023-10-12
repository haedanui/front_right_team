package com.fbp;

import java.util.Map;

import lombok.Getter;

@Getter
public class Response {
    private static final String NEW_LINE = "\r\n";
    private static final String VERSION = "HTTP/1.1";

    private String httpVersion;
    private int statusCode;
    private String contentType;
    private byte[] content;

    public Response(int statusCode, String contentType, byte[] content) {
        this(VERSION, statusCode, contentType, content);
    }

    public Response(String version, int statusCode, String contentType, byte[] content) {
        this.httpVersion = version;
        this.statusCode = statusCode;
        this.content = content;
        this.contentType = contentType;
    }

    private boolean isTextContent() {
        return (contentType.indexOf("text") == -1);
    }

    public String getHeader() {
        StringBuilder sb = new StringBuilder();

        // status line.
        sb.append(String.format("%s %s %s", httpVersion, statusCode, map.get(statusCode)));
        sb.append(NEW_LINE);
        // sb.append("Date: ", getFormatedDate());
        // sb.append(NEW_LINE);

        if (content != null) {
            sb.append("Content-Type: " + contentType);
            sb.append(NEW_LINE);
            sb.append("Content-Length: " + content.length);
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "";
    }
}