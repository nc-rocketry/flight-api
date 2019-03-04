ul(class:"nav nav-pills") {
    li(class:"nav-item") { span("Motors by Diameter: ") }
    diameters.each { d ->
        li(class:"nav-item") {
            a(class:"nav-link", href:"api/v2/search/diameter/$d.diameter", " ${d.diameter}mm ")
        }
    }
}
