ul(class:"nav") {
    if (crumbs != null) {
        crumbs.each { c -> li(class:"nav-item") { a(href:c.url, c.text) } }
        yield '&nbsp;'
    }
}