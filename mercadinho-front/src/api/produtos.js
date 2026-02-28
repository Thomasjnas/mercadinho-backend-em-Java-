// URL do backend Spring Boot
const API_URL = "http://localhost:8080";

// Busca lista de produtos
export async function buscarProdutos() {
  const res = await fetch(`${API_URL}/produtos`);
  if (!res.ok) {
    throw new Error(`Erro ao buscar produtos: ${res.status}`);
  }
  return res.json();
}