const API_URL = "http://localhost:8080";

export function basicAuthHeader(email, senha) {
  // Basic base64("email:senha")
  const token = btoa(`${email}:${senha}`);
  return { Authorization: `Basic ${token}` };
}

export async function listarProdutos(auth) {
  const res = await fetch(`${API_URL}/produtos`, {
    headers: {
      "Content-Type": "application/json",
      ...auth,
    },
  });
  if (!res.ok) throw new Error(`Erro ao listar produtos: ${res.status}`);
  return res.json();
}

export async function criarProduto(produto, auth) {
  const res = await fetch(`${API_URL}/produtos`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      ...auth,
    },
    body: JSON.stringify(produto),
  });
  if (!res.ok) throw new Error(`Erro ao criar produto: ${res.status}`);
  return res.json();
}

export async function me(auth) {
  const res = await fetch(`${API_URL}/auth/me`, { headers: { ...auth } });
  if (!res.ok) throw new Error("Credenciais inválidas");
  return res.json();
}