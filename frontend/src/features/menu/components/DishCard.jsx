export const DishCard = ({ name, price, category, time }) => (
  <div className="p-4 border rounded-2xl shadow-sm hover:shadow-md transition-all">
    <div className="flex justify-between items-start">
      <h3 className="text-lg font-bold text-gray-800">{name}</h3>
      <span className="bg-orange-100 text-orange-600 text-xs px-2 py-1 rounded-full">
        {category}
      </span>
    </div>
    <div className="mt-4 flex justify-between items-center text-sm text-gray-500">
      <span>{price} $</span>
      <span>⏱ {time} мин</span>
    </div>
    <button className="mt-4 w-full py-2 bg-black text-white rounded-xl active:scale-95 transition-transform">
      Заказать
    </button>
  </div>
);