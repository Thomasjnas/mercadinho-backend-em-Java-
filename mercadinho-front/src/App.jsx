import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import LojaPage from "./pages/LojaPage";
import PagamentoPage from "./pages/PagamentoPage";
import SucessoPage from "./pages/SucessoPage";
import ProtectedRoute from "./auth/ProtectedRoute";
import "./App.css";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* ✅ primeira tela */}
        <Route path="/" element={<LoginPage />} />

        {/* ✅ cadastro separado */}
        <Route path="/register" element={<RegisterPage />} />

        {/* protegidas */}
        <Route
          path="/loja"
          element={
            <ProtectedRoute>
              <LojaPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/pagamento"
          element={
            <ProtectedRoute>
              <PagamentoPage />
            </ProtectedRoute>
          }
        />
        <Route
          path="/sucesso"
          element={
            <ProtectedRoute>
              <SucessoPage />
            </ProtectedRoute>
          }
        />

        <Route path="*" element={<LoginPage />} />
      </Routes>
    </BrowserRouter>
  );
}