import http from "@/lib/http";

export function postHoaxAttachment(attachment){
    return http.post("/api/v1/hoax-attachments", attachment);
}