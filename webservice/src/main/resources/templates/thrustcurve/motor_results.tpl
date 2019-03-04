layout 'layouts/simple.tpl',
page_title: 'Search Thrustcurve API',
impulses: impulses,
diameters: diameters,
banner: contents {
    include template:"layouts/simple/banner.tpl"
},
crumbs: contents {
    //include template:"snipit/motors_by_diameter.tpl"
    include template:"snipit/motors_by_impulse.tpl"
},
content: contents {
    div(class:"container-fluid", align:"left", position:"left") {
        div(class:"row") {
             div(class:"col label left", "Designation")
             div(class:"col label center", "Details" )
             div(class:"col label left", "Propellant" )
             div(class:"col label left", "Manufacturer" )
             // div(class:"col label left", "Motor Case" )

        }
        motors.each { m ->
            div(class:"row") {
                div(class:"col value") {
                    a(href:"/thrustcurve/motor/$m.externalId", "$m.designation [$m.manufacturer.abbreviation]")
                }
                div(class:"col value") {
                    div(class:"container") {
                        div(class:"row") {
                            div(class:"col sm-label") { yield "Diameter:" }
                            div(class:"col sm-value") { yield "${m.diameter}mm" }
                        }
                        div(class:"row") {
                            div(class:"col sm-label") { yield "Weight:" }
                            div(class:"col sm-value") { yield "${m.weight}oz" }
                        }
                        div(class:"row") {
                            div(class:"col sm-label") { yield "Length:" }
                            div(class:"col sm-value") { yield "${m.length}" }
                        }
                        div(class:"row") {
                            div(class:"col sm-label") { yield "Length:" }
                            div(class:"col sm-value") { yield "${m.length}" }
                        }
                        div(class:"row") {
                            div(class:"col sm-label") { yield "Burn:" }
                            div(class:"col sm-value") { yield "${m.burnTime}s" }
                        }
                    }
                }
                // div(class:"col value") { yield m.motorCase }
                div(class:"col value") { yield m.propellant }
                div(class:"col value") { yield m.manufacturer.name }
            }
            div(class:"row") {
                div(class:"col value") {
                    div(class:"container") {
                        div(class:"row") {
                            div(class:"col sm-label") { yieldUnescaped "Sim&nbsp;Files:" }
                            div(class:"col sm-value") {
                                m.data.each { d ->
                                    yield " "
                                    a(href:"${d.infoUrl}", target:"_blank", "${d.filename}")
                                }
                            }

                        }
                    }
                }
            }
            div(class:"row", style:"background:#000000;") { br(); yieldUnescaped "&nbsp;" }
        }

    }
},
footer: contents {
    include template:"layouts/simple/footer.tpl"
}
