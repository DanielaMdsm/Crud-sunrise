const cantidad= document.getElementById('cantidad');
const categoria= document.querySelector("#categoria");
const formEntrada= document.querySelector("#entrada");
const valorPagar= document.querySelector("#valorPagar"); 

formEntrada.addEventListener('submit',(event)=>{ 
    event.preventDefault(); 
    var cantidad1= cantidad.value;
    var categoria1=categoria.value;
    console.log(cantidad1);
    let valor;
    let descuento;
    if(categoria1=="Niño"){
        descuento= Math.round(1000*(1-0.8));
        valor=descuento*cantidad1;
    }else if(categoria1=="Jubilado"){
        descuento=1000*(1-0.5);
        valor=descuento*cantidad1;
    }else if(categoria1=="Estudiante"){
        descuento=1000*(1-0.3);
        valor=descuento*cantidad1;
    }else{
        valor=1000*cantidad1;
    } 
    console.log(valor)
    valorPagar.innerText=`$ ${valor}`;

}) 

formEntrada.addEventListener('reset',()=>{
    valorPagar.innerText="";
})
