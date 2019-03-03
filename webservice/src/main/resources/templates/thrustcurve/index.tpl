layout 'layouts/simple.tpl',
page_title: 'Thrustcurve API',
crumbs: [ ],
content: contents {
    diameters.each { d ->
        ul(class:"nav-item") { a(href:"search/diameter/$d.getDiameter()", "$d.getDiameter()") }
    }
    impulses.each { impulse ->
        ul(class:"nav-item") { a(href:"search/impulse/$impulse.getImpulse()", "$impulse.getImpulse()") }
    }
    table {
        tbody {
            tr {
                td { a(href:"search/impulse/I", "I") }
                td { a(href:"/", "HOME") }
            }
        }
    }
}
