function mostrarContenido(opcion) {
    const contenedor = document.getElementById(`div-${opcion}`);
    let contenido = '';

    contenedor.hidden = !contenedor.hidden

    switch (opcion) {
        case 'featured':
            contenido = `<button>Extra Comfort Shoes</button><br>
                        <button>Chunky & Retro Shoes</button><br>
                        <button>Customize Our Shoes</button><br>
                        <button>Slip On Shoes</button><br>
                        <button>Mary Jane Shoes</button><br>
                        <button>Platform Shoes</button><br>
                        <button>Skate Shoes</button><br>
                        <button>Sandals and Slides</button><br>
                        <button>Offers & Promotions</button><br>
                        <button>Gift Cards</button><br>`
            break;
        case 'icons':
        case 'shop':
        case 'sports':
        case 'support':
        case 'about':
            break;
    }
    contenedor.innerHTML = contenido;
}


