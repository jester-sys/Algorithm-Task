package com.jaixlabs.algorithmtask.Adapter

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaixlabs.algorithmtask.databinding.ItemNumberBinding

class NumberAdapter(
    private var numbers: List<Int>,
    private var rule: String
) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    inner class NumberViewHolder(val binding: ItemNumberBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val number = numbers[position]
        holder.binding.textNumber.text = number.toString()

        val isMatching = matchesRule(number, rule)
        val startColor = (holder.binding.root.background as? android.graphics.drawable.ColorDrawable)?.color ?: Color.parseColor("#EEEEEE")
        val endColor = if (isMatching) getHighlightColor(rule) else Color.parseColor("#EEEEEE")

        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), startColor, endColor)
        colorAnimation.duration = 400
        colorAnimation.addUpdateListener { animator ->
            holder.binding.root.setBackgroundColor(animator.animatedValue as Int)
        }
        colorAnimation.start()
    }

    // This function will decide color according to rule
    private fun getHighlightColor(rule: String): Int {
        return when (rule) {
            "Odd Numbers" -> Color.parseColor("#ADD8E6") // Light Blue
            "Even Numbers" -> Color.parseColor("#90EE90") // Light Green
            "Prime Numbers" -> Color.parseColor("#FFA500") // Orange
            "Fibonacci Numbers" -> Color.parseColor("#9370DB") // Medium Purple
            else -> Color.parseColor("#EEEEEE") // Default Light Gray
        }
    }

    override fun getItemCount(): Int = numbers.size

    fun updateRule(newRule: String) {
        rule = newRule
        notifyDataSetChanged()
    }

    private fun matchesRule(number: Int, rule: String): Boolean {
        return when (rule) {
            "Odd Numbers" -> number % 2 != 0
            "Even Numbers" -> number % 2 == 0
            "Prime Numbers" -> isPrime(number)
            "Fibonacci Numbers" -> isFibonacci(number)
            else -> false
        }
    }

    private fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }

    private fun isFibonacci(n: Int): Boolean {
        fun isPerfectSquare(x: Int): Boolean {
            val s = Math.sqrt(x.toDouble()).toInt()
            return s * s == x
        }
        return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4)
    }
}
