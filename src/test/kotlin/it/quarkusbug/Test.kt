import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test
import java.util.stream.IntStream

@QuarkusTest
class Test {


    @Test
    internal fun breakOnMultipleRequests() {


        IntStream.range(0, 30).parallel().forEach {

            getResponse()!!.body("errors", nullValue())

        }


    }


    fun getResponse(): ValidatableResponse? {
        return given().body(
            "{\"query\":\"{\n  exampleQuery {\n    hello\n    hello2\n  }\n}\",\"variables\":null}"
        )
            .with().header(
                "Authorization",
                " Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJYNDdZMjIweUhmX29EWGJFSTYyODRmM1lPSHlZaXVxTHl3N3huREJkQWE4In0.eyJleHAiOjE2NTk0MzIxNjIsImlhdCI6MTY1OTQzMTg2MiwiYXV0aF90aW1lIjoxNjU5NDMxNzM0LCJqdGkiOiJkYzI5MTI4OS00NDM5LTQzMzUtOGRjMi1mZDU0OGI3NjJjZWMiLCJpc3MiOiJodHRwczovL3BwbmV4dC1kZXYuYXdzLnJnaWdyb3VwLmNvbS9hdXRoL3JlYWxtcy9hY21lZGV2IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjBlZDc5ZWJjLTEyOTItNDQ0Ny04MDM2LTk3N2VlY2M3NjliMSIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNsaWVudC1sb2NhbCIsIm5vbmNlIjoiZTU3ZjVjNjItMzIzMC00MGUyLTg0MDUtODBiYWJkODBmY2I5Iiwic2Vzc2lvbl9zdGF0ZSI6ImM5M2E1Y2RjLWIxNTgtNGU1ZS1iNjllLWJjMTA5NzUyYTNhOSIsImFjciI6IjAiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiY29uZmlndXJhdG9yIiwiZGVmYXVsdC1yb2xlcy1hY21lZGV2Iiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsIm5hbWUiOiJ0ZXN0IHRlc3QiLCJyZWFsbSI6ImFjbWVkZXYiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ0ZXN0IiwiZ2l2ZW5fbmFtZSI6InRlc3QiLCJmYW1pbHlfbmFtZSI6InRlc3QiLCJlbWFpbCI6InRlc3RAdGVzdC5pdCJ9.ewtUBxh5j3znIwFknXVj3IjBG9tR6Kz6Szb08H1SQ88iv_d0Pzo5C2OSmK1g2JB12T5de80aPtdSUPnFGIJD_JLIus77RqsToL5rvBJw7PAtzY8EGDk_SGPqhwe-AcDop2rehdyyrR1wDWYvvSIbJrBxpkUR5gcYNJAj6Tafpr1RETlnG2pNwhcN0DIB1DgStb7O_EuKytWUSrXoeJM3FcM2GF2PcnBWpIj073SVyVu_F2-fIsHglQo6qZp2bz7DALwwZ5p01Rb7pFg7HE9RS0Gk8vZdImXyFZ-2QRzS220F6wCqq6y5T7BJB-knXE2Bhwu8rWiTVdMW7-tONVozOw"
            )
            .log()
            .all(true)
            .`when`()
            .post("/graphql")
            .then()
    }
}
