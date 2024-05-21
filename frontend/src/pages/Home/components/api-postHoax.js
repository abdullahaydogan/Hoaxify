import http from "@/lib/http";

export function postHoax(hoax){
    return http.post("/api/v1/hoaxes", hoax);
}