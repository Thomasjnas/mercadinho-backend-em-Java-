import { Navigate } from "react-router-dom";
import { pegarCredenciais } from "./auth";

export default function ProtectedRoute({ children }) {
  const cred = pegarCredenciais();
  if (!cred) return <Navigate to="/" replace />;
  return children;
}