    document.addEventListener('DOMContentLoaded', () => {
        const carritoItemsContainer = document.getElementById('carrito-items');
        const totalGeneralSpan = document.getElementById('total-general');
        const procederPagoBtn = document.getElementById('proceder-pago-btn');

        function getCarrito() {
            const carritoJSON = localStorage.getItem('carrito');
            return carritoJSON ? JSON.parse(carritoJSON) : [];
        }

        function saveCarrito(carrito) {
            localStorage.setItem('carrito', JSON.stringify(carrito));
        }

        function añadirAlCarrito(producto) {
            let carrito = getCarrito();
            const productoExistente = carrito.find(item => item.id === producto.id);

            if (productoExistente) {
                productoExistente.cantidad++;
            } else {
                carrito.push({ ...producto, cantidad: 1 });
            }
            saveCarrito(carrito);
            renderizarCarrito();
            alert(`${producto.modelo} añadido al carrito!`);
        }

        function actualizarCantidad(id, nuevaCantidad) {
            let carrito = getCarrito();
            const productoIndex = carrito.findIndex(item => item.id === id);

            if (productoIndex > -1) {
                if (nuevaCantidad > 0) {
                    carrito[productoIndex].cantidad = nuevaCantidad;
                } else {
                    carrito.splice(productoIndex, 1);
                }
                saveCarrito(carrito);
                renderizarCarrito();
            }
        }

        function eliminarDelCarrito(id) {
            let carrito = getCarrito();
            carrito = carrito.filter(item => item.id !== id);
            saveCarrito(carrito);
            renderizarCarrito();
        }

        function calcularTotal() {
            const carrito = getCarrito();
            return carrito.reduce((total, item) => total + (item.precio * item.cantidad), 0).toFixed(2);
        }

        function renderizarCarrito() {
            if (!carritoItemsContainer) return;

            carritoItemsContainer.innerHTML = '';
            const carrito = getCarrito();

            if (carrito.length === 0) {
                carritoItemsContainer.innerHTML = '<tr><td colspan="5">Tu carrito está vacío.</td></tr>';
            } else {
                carrito.forEach(item => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${item.modelo}</td>
                        <td>$${item.precio.toFixed(2)}</td>
                        <td>
                            <input type="number" value="${item.cantidad}" min="1" class="cantidad-input" data-id="${item.id}">
                        </td>
                        <td>$${(item.precio * item.cantidad).toFixed(2)}</td>
                        <td>
                            <button class="eliminar-btn" data-id="${item.id}">Eliminar</button>
                        </td>
                    `;
                    carritoItemsContainer.appendChild(row);
                });
            }
            totalGeneralSpan.textContent = calcularTotal();

            document.querySelectorAll('.eliminar-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const id = parseInt(event.target.dataset.id);
                    eliminarDelCarrito(id);
                });
            });

            document.querySelectorAll('.cantidad-input').forEach(input => {
                input.addEventListener('change', (event) => {
                    const id = parseInt(event.target.dataset.id);
                    const nuevaCantidad = parseInt(event.target.value);
                    actualizarCantidad(id, nuevaCantidad);
                });
            });
        }

        if (document.getElementById('productos-container')) {
            document.getElementById('productos-container').addEventListener('click', (event) => {
                if (event.target.classList.contains('add-to-cart-btn')) {
                    const button = event.target;
                    const producto = {
                        id: parseInt(button.dataset.id),
                        modelo: button.dataset.modelo,
                        precio: parseFloat(button.dataset.precio),
                        imagen: button.dataset.imagen
                    };
                    añadirAlCarrito(producto);
                }
            });
        }

        if (procederPagoBtn) {
            procederPagoBtn.addEventListener('click', () => {
                let carrito = getCarrito();
                if (carrito.length > 0) {
                    alert('¡Compra realizada con éxito! Total: $' + calcularTotal());
                    localStorage.removeItem('carrito');
                    renderizarCarrito();
                } else {
                    alert('Tu carrito está vacío. Añade productos antes de proceder al pago.');
                }
            });
        }

        renderizarCarrito();
    });
    