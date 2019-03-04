form(method:"post", target="/api/v1/search/impulse") {
    div(class:"container") {
        div(class:"row") {
            div(class:"col label") { p("Impulse:") ) }
            div(class:"col value") { input(type:"text", name:"motor_impulse") }
            div(class:"col") { input(type:"text", name:"something") }
        }
    }
}

