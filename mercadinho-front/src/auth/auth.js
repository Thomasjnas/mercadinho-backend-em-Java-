// auth.js — autenticação simples usando Basic Auth (para demo)
// Em projeto real, trocar por JWT (token).

const KEY = "mercadinho_auth";

export function salvarCredenciais(email, senha) {
  localStorage.setItem(KEY, JSON.stringify({ email, senha }));
}

export function pegarCredenciais() {
  const raw = localStorage.getItem(KEY);
  return raw ? JSON.parse(raw) : null;
}

export function sair() {
  localStorage.removeItem(KEY);
}

export function getAuthHeader() {
  const cred = pegarCredenciais();
  if (!cred) return {};
  const token = btoa(`${cred.email}:${cred.senha}`);
  return { Authorization: `Basic ${token}` };
}   