import { useState, useEffect } from 'react';
import { getDishes } from '../../../api/dishes';

export const useDishes = () => {
  const [dishes, setDishes] = useState([]);
  const [loading, setLoading] = useState(true);

  const refreshDishes = () => {
    setLoading(true);
    getDishes().then(res => {
      setDishes(res.data);
      setLoading(false);
    });
  };

  useEffect(() => {
    refreshDishes();
  }, []);

  return { dishes, loading, refreshDishes };
};