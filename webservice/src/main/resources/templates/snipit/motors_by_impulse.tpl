ul(class:"nav") {
    yieldUnescaped "Motors by Impulse: &nbsp;"
    impulses.each { i ->
        li(class:"nav-item") {
            a(class:"nav-link", href:"api/v2/search/impulse/$i.impulse", "$i.impulse")
        }
    }
}
