import React, { useEffect, useState } from 'react';
import { dishApi } from '../api/dishes';

const MenuPage = () => {
  const [dishes, setDishes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadDishes = async () => {
      try {
        const data = await dishApi.getAll();
        setDishes(data);
      } catch (error) {
        console.error("Ошибка при загрузке меню:", error);
      } finally {
        setLoading(false);
      }
    };
    loadDishes();
  }, []);

  if (loading) return <div>Загрузка меню...</div>;

  return (
    <div className="grid grid-cols-1 md:grid-cols-3 gap-4 p-6">
      {dishes.map(dish => (
        <div key={dish.id} className="border p-4 rounded-xl shadow-sm hover:shadow-md transition">
          <h2 className="text-xl font-bold">{dish.name}</h2>
          <p className="text-gray-500">Категория: {dish.category}</p>
          <div className="flex justify-between mt-4 items-center">
            <span className="text-orange-600 font-bold">{dish.price} $</span>
            <span className="text-sm text-gray-400">⏱ {dish.time} мин</span>
          </div>
        </div>
      ))}
    </div>
  );
};