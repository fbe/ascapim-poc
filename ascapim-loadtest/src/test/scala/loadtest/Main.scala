package loadtest

import io.gatling.core.Predef._ // 2
import io.gatling.http.Predef._
import scala.concurrent.duration._


class Main extends Simulation {

  val scn = scenario("sim")
    .exec(http("request_1")
      .get("http://localhost:1080/"))
    .pause(5)

  setUp(scn.inject(atOnceUsers(100)))
}
