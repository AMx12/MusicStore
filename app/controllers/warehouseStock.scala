package controllers

import models.storeItem
import play.api.mvc.Controller
class warehouseStock extends Controller {

  val guitars = List(
    storeItem("AM1001", "Chapman", "ML1-7 Pro Modern", "CML1", "images/chapmanML1.jpg", "Chapman ML1-7 Pro Modern, a 7-string behemoth, finished in beautiful Iris Sea.", 1039),
    storeItem("AM1002", "ESP LTD", "KH-Demonology", "ESP-KH", "images/espKH.jpg", "ESP LTD KH-Demonology Kirk Hammett signature in black, Metallica's Kirk Hammett producing an axe worth of Satan himself!", 1290),
    storeItem("AM1003", "Gibson", "US 2018 Les Paul", "GUS8LP", "images/gibsonLPWorn.jpg", "INFO", 799),
    storeItem("AM1004", "Ibanez", "JS2450", "IJS2450", "images/ibanezJS.jpg", "INFO", 2269),
    storeItem("AM1005", "Ibanez", "RGDIX7MPB", "IRGD", "images/ibanezRGD.jpg", "INFO", 799),
    storeItem("AM1006", "Schecter", "C-7 SLS Elite", "SC7E", "images/schecterC7.jpg", "INFO", 1329)
  )


}
