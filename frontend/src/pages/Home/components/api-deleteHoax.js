import http from "@/lib/http";

export function deleteHoax(id){
    return http.delete(`/api/v1/hoaxes/${id}`);
}