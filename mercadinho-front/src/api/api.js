const API_URL = "http://localhost:8080";

// Faz login “validando” no backend via /auth/me (rota protegida)
export async function login(email, senha) {
  const token = btoa(`${email}:${senha}`);

  const res = await fetch(`${API_URL}/auth/me`, {
    method: "GET",
    headers: { Authorization: `Basic ${token}` },
  });

  if (!res.ok) {
    throw new Error("Email ou senha inválidos.");
  }

  return res.json();
}

// Register é liberado (permitAll)
export async function register(email, senha) {
  const res = await fetch(`${API_URL}/auth/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, senha }),
  });

  if (!res.ok) {
    throw new Error("Não foi possível registrar (talvez email já exista).");
  }

  return res.json();
}

export async function buscarProdutos() {
  const res = await fetch(`${API_URL}/produtos`);
  if (!res.ok) throw new Error(`Erro ao buscar produtos: ${res.status}`);
  return res.json();
}

// Checkout no backend (rota protegida)
export async function checkout(payload, authHeader) {
  const res = await fetch(`${API_URL}/checkout`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      ...authHeader,
    },
    body: JSON.stringify(payload),
  });

  if (!res.ok) throw new Error("Falha ao efetuar pagamento.");
  return res.json();
}