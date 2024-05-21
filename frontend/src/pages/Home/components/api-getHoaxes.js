import http from "@/lib/http";

export function getHoaxes(page = 0){
    return http.get("/api/v1/hoaxes?page=" + page);
}