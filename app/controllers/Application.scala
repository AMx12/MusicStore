package controllers

import models.storeItem
import play.api._
import play.api.mvc._

import scala.collection.mutable.ListBuffer

class Application extends Controller {

  val guitars = List(
    storeItem("guitar", "G1001", "Chapman", "ML1-7 Pro Modern", "CML1", "chapmanML1.jpg", "The ML1 Pro Modern 7 String is here! This Dual-Humbucker S-Style guitar just oozes classes and absolute brutality in equal measure. This is thanks to its stunningly comfortable body carve and powerful Primordial pickups that’ll rock the front-end of any amp you plug into.\n\nThe Ebony fretboard gives your notes clarity and the smooth feeling neck makes it easy to go from lead to rhythm and between with ease. The string-through bridge will make the body resonate more giving you more attack and more sustain and even better tuning stability.", 1039),
    storeItem("guitar", "G1002", "ESP LTD", "KH-Demonology", "ESP-KH", "espKHSig.jpg", "Metallica's Kirk Hammett is fascinated by the strange and macabre aspects of life, evidenced by his custom guitars featuring classic horror art and paranormal phenomena, most famously seen in his well-known Ouija guitars. The next step in his ESP-LTD Signature Series is the KH Demonology, a guitar powerful enough to summon the mightiest of dark forces. Over its black finish are a number of sigils, which are ancient symbols reputed to be imbued with magical power that allows the owner to summon demonic entities.\n\nWhether or not you use the KH Demonology as a portal to magical dimensions, it's an amazing musical instrument in its own right. The KH Demonology is a neck-thru-body design at 25.5\" scale, with a comfortably contoured alder body, an extra-thin U-shaped three-piece maple neck, and a rosewood fingerboard inlaid with Kirk's skull-and-crossbones motif, along with 24 extra-jumbo frets.", 1290),
    storeItem("guitar", "G1003", "Fender", "JR-Telecaster", "FJRT", "fenderJRSig.jpg", "Unleash your metal side with this stunning Jim Root Tele.\n\n The timeless body shape keep this looking like a classic and the loaded EMG 60 (Neck) EMG 81 (Bridge) pickups help deliver all the metal tones you could ever ask for. Plenty of modern features for big sounds! The Jim Root Telecaster (designed for the Slipknot/Stone Sour guitarist) will go to 11! Special features include a mahogany body, 12\"-radius fingerboard, EMG® pickups, 22 Dunlop 6100 jumbo frets, black locking tuners and hardware, and a single volume knob.", 939),
    storeItem("guitar", "G1004", "Gibson", "US 2018 Les Paul", "GUS8LPB", "gibsonLPFBourbon.jpg", "The Les Paul Faded guitar fully embodies the celebrated Les Paul feel and tone in a spirited, worn finish. The mahogany body and maple top complement a pair of genuine PAF-inspired humbucking pickups to deliver the impressive power and sustain made famous by legendary Les Paul guitars.\n\nThe Les Paul Faded is also extremely comfortable to play thanks to the innovative Ultra-Modern weight relief and Slim Taper neck.", 799),
    storeItem("guitar", "G1005", "Gibson", "US 2018 Les Paul", "GUS8LPC", "gibsonLPFCherry.jpg", "The Les Paul Faded guitar fully embodies the celebrated Les Paul feel and tone in a spirited, worn finish. The mahogany body and maple top complement a pair of genuine PAF-inspired humbucking pickups to deliver the impressive power and sustain made famous by legendary Les Paul guitars.\n\nThe Les Paul Faded is also extremely comfortable to play thanks to the innovative Ultra-Modern weight relief and Slim Taper neck.", 799),
    storeItem("guitar", "G1006", "Ibanez", "JS2450", "IJS2450", "ibanezJSSig.jpg", "Developed with precision-perfect performance in mind, the Ibanez JS2450 Joe Satriani Signature Electric Guitar offers articulate tonal clarity alongside extremely comfortable and responsive playability. Whether you're ripping it up with intense solos or your holding back with sensitivity in mind, the JS2450 won't let you down. Boasting an extremely fluid, smooth and and provocatively curvy design, complimented by its  special JS neck profile, you will find wearing and playing this stunning electric guitar an absolute dream!\n\nTwo DiMarzio humbucking pickups, partnered with push/pull coil tapping and highpass filter give you a tonal variety that will seem endless. This is one guitar that seriously wants you to explore its depth and variation. It also has an Edge tremolo and 6105 frets thrown into the mix, adding to the sheer beauty of the craftsmanship of this instrument.", 2269),
    storeItem("guitar", "G1007", "Ibanez", "RGDIX7MPB", "IRGD", "ibanezRGD.jpg", "The Ibanez RGDIX7MPB model hails from the well-renowned RGD series of guitars, however it has an entirely new and unique build unlike its close relatives in the range. Still instantly recognisable thanks to its deep bevelled body and extra horn cut accompanied by a longer 26.5 inch scale neck, the RGDIX7MPB is a 7-string monster in a dazzling Surreal Blue Burst finish.", 799),
    storeItem("guitar", "G1008", "Jackson", "MT-SL2 Soloist", "JMT", "jacksonMTSig.jpg", "Slipknot lead guitarist Mick Thomson is one of metal’s most successful and revered players. His game changing, take-no-prisoners approach to metal guitar has influenced countless musicians worldwide, while his black hole-heavy de-tuned guitar sound has been an integral part of Slipknot for more than two decades. Capable of handling his acclaimed aggressive technique and tone, the USA Signature Mick Thomson Soloist™ is a sinister axe loaded with premium features including genuine mahogany body wings coupled with a graphite reinforced through-body three-piece maple neck—carved to a custom super-thin profile for maximum comfort and highspeed playability, and a 12”-16” compound radius ebony fingerboard with 24 frets. This signature Soloist is powered by a pair of Mick Thomson signature Seymour Duncan® Blackouts to complement the complex, crushing riffs Thomson plays in dropped tunings.", 3263),
    storeItem("guitar", "G1009", "Schecter", "C-7 SLS Elite", "SC7E", "schecterC7.jpg", "The C series is Schecter's flagship range, and the new for 2018 SLS Elite model has a number of premium features and refinements to suit the most serious of shredders. With a pair of active Fishman Fluence pickups, a Hipshot hardtail bridge and a gorgeous Antique Fade Burst finish, this guitar truly belongs in the 21st Century with its modern features and classy aesthetics.", 1329),
    storeItem("guitar", "G1010", ".strandberg*", "Plini Boden OS 6", "sPB6", "strandbergPSig.jpg", "We are very excited to announce the availability of a limited run of Boden OS 6 guitars made especially for Paul Masvidal of Cynic, and Plini! They feature a solid Hawaiian Koa top, Swamp Ash body, Birdseye Maple patented EndurNeck™ with Carbon Fiber reinforcements and Walnut laminates, Ebony Fingerboard with glow in the dark side markers and inlays, and 24 Jumbo Stainless Steel frets in a 25.5″ – 25″ fan. The pickups are Seymour Duncan Jazz/JB, and the guitars are delivered in the more exclusive padded gig case used in the Custom Shop. The Paul Masvidal model features the world debut of the new fanned fret tremolo, and a signature “Masvidalien” inlay on the 12th fret. The Plini model features a fixed bridge and the Plini crescent moon inlay.", 2499),
    storeItem("amp", "A1001", "Victory x Orange", "SuperKraken x JR#4 212", "vxo", "andySpecial.jpg", ".", 1750),
    storeItem("amp", "A1002", "Hughes & Kettner", "GrandMeister x TC 412 A60", "hkc", "h&kCombo.jpg", ".", 1850),
    storeItem("amp", "A1003", "Orange x Jim Root", "JR#4 Terror x JR#4 212", "hkc", "jimRootCombo.jpg", ".", 900)


  )

  var cart = List[String]()


  def index = Action {
    Ok(views.html.carousel(guitars))
    //Ok(views.html.productPage())
  }

  def guitarsPage = Action {
    Ok(views.html.guitarsPage(guitars))
  }

  def ampsPage = Action {
    Ok(views.html.ampsPage(guitars))
  }

  def productPage(productType: String, productID: String, productName: String) = Action {
    Ok(views.html.productPage(productType, productID, productName, guitars))
  }

  def basket(productID: String) = Action {
    cart ::= productID
    Ok(views.html.basket(productID, cart, guitars))
  }

//  def cartAddition(productID: String) = Action {
//    Ok(cart ::= productID)
//  }

}