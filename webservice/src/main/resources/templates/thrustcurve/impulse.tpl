layout 'layouts/simple.tpl',
page_title: 'Search Thrustcurve API',
impulses: impulses,
diameters: diameters,
banner: contents {
    include template:"layouts/simple/banner.tpl"
},
crumbs: contents {
    include template:"snipit/motors_by_diameter.tpl"
    include template:"snipit/motors_by_impulse.tpl"
},
content: contents {
    div(class:"container", align:"left", position:"left") {
        div(class:"row") {
             div(class:"col label", "Designation")
             div(class:"col label", "Manufacturer" )
             div(class:"col label", "Diameter (mm)" )
             div(class:"col label", "Weight (oz)" )
             div(class:"col label", "Length" )
             div(class:"col label", "Burn Time (s)" )
             div(class:"col label", "Motor Case" )
             //div(class:"col label", "Data" )
        }
        motors.each { m ->
            div(class:"row") {
                div(class:"col value") { a(href:"/thrustcurve/motor/$m.externalId", "$m.designation [$m.manufacturer.abbreviation]") }
                div(class:"col value") { yield m.manufacturer.name }
                div(class:"col value") { yield m.diameter }
                div(class:"col value") { yield m.weight }
                div(class:"col value") { yield m.length }
                div(class:"col value") { yield m.burnTime }
                div(class:"col value") { yield m.motorCase }
                //div(class:"col value") {
                   //div(class:"container")
                   //div(class:"row") {
                       //motors.data.each { data ->
                           //div(class:"col value") { yield data.infoUrl }
                           //div(class:"col value") { yield data.dataUrl }
                       //}
                   //}
                //}
            }
        }

    }
},
footer: contents {
    include template:"layouts/simple/footer.tpl"
}