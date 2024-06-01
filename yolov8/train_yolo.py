from ultralytics import YOLO
import torch
import torch.optim.lr_scheduler as lr_scheduler

# 设置训练参数
data_path = '/root/data1/lcy/zhuwei/datasets/Thyroid/data.yaml'
model_path = 'yolov8s.yaml'
pretrained_weights = 'ultralytics/yolov8s.pt'
epochs = 10000
batch_size = 4
initial_lr = 0.01  # 初始学习率
resume = True

# 初始化模型
model = YOLO(model_path, pretrained=pretrained_weights)

# 设置优化器
optimizer = torch.optim.Adam(model.parameters(), lr=initial_lr)

# 设置学习率调度器（余弦退火）
scheduler = lr_scheduler.CosineAnnealingLR(optimizer, T_max=epochs)

# 自定义训练函数
def train_model():
    # 加载数据
    data = model.load_data(data_path)
    
    # 设置训练参数
    model.train_params['epochs'] = epochs
    model.train_params['batch_size'] = batch_size
    model.train_params['optimizer'] = optimizer
    
    for epoch in range(epochs):
        # 开始训练
        model.train(
            data=data,
            epochs=1,  # 每次训练一个epoch
            batch_size=batch_size,
            optimizer=optimizer,
            resume=resume
        )
        
        # 更新学习率
        scheduler.step()

if __name__ == "__main__":
    train_model()

