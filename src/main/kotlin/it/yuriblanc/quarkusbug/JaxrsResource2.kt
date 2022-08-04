package it.yuriblanc.quarkusbug

import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("{tenantId}/example2")
class JaxrsResource2 {
    @POST
    fun example(): String {
        return "hello2!"
    }
}
