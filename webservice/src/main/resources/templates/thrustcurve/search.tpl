layout 'layouts/simple.tpl',
page_title: 'Search Thrustcurve API',
crumbs: [ ],
content: contents {
    br()
    ul(class:"nav flex") {
        yieldUnescaped "Motors by Diameter: &nbsp;"
        diameters.each { d ->
            li(class:"nav-item") {
                a(href:"api/v2/search/diameter/$d.diameter", "$d.diameter")
                yieldUnescaped '&nbsp;|&nbsp;'
            }
        }
    }
    ul(class:"nav flex") {
        yieldUnescaped "Motors by Impulse: &nbsp;"
        impulses.each { i ->
            li(class:"nav-item") {
                a(href:"api/v2/search/impulse/$i.impulse", "$i.impulse")
                yieldUnescaped '&nbsp;|&nbsp;'
            }
        }
    }

    form(method:"post", target="/api/v1/search/impulse") {
        input(type:"text", name:"motor_impulse")
        input(type:"text", name:"something")
    }

}
