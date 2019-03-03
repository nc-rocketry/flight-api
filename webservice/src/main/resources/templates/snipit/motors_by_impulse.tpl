ul(class:"nav nav-tabs") {
    yieldUnescaped "Motors by Impulse: &nbsp;"

    if (selected_impulse != null) {
        impulses.each { i ->
            if (selected_impulse.equals(i.impulse)) {
                li(class:"nav-item active") {
                    a(class:"nav-link active", href:"/thrustcurve/impulse/$i.impulse", "$i.impulse")
                }
            } else {
                li(class:"nav-item") {
                    a(class:"nav-link", href:"/thrustcurve/impulse/$i.impulse", "$i.impulse")
                }
            }
        }
    } else {
        impulses.each { i ->
            li(class:"nav-item") {
                a(class:"nav-link", href:"/thrustcurve/impulse/$i.impulse", "$i.impulse")
            }
        }
    }
}
